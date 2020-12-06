package main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;


public class OntologyTest {
	
	static String genreName = "" ;
	static String countryName = "";
	static String titleName = "";
	static String searchBy = "";
	
	

	
	static String strQuery3 = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
			+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
			+ "PREFIX mo: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/MovieOntology#>\n"
			+ "PREFIX ro: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/RatingOntology#>\n"
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
			+ "SELECT ?subject ?TID ?title ?averageRating ?numVotes \n"
			+ "WHERE {\n"
				+ "SERVICE <http://34.123.102.237:3030/ds/query>"
				+ "{"
					+ "SELECT ?subject ?TID ?title ?averageRating ?numVotes \n"
					+ "WHERE {\n"
						+ "?subject ro:hasTitleId ?TID."
						+ "?subject ro:numberOfVotes ?numVotes."
						+ "?subject ro:averageRating ?averageRating."
						+ "?subject ro:hasTitle ?title."
					+ "}"
				+ "}"
			+"}";
	
				
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//searchBy = SPARQLQuery.searchByTitle(titleName);
		try {
			Model model = ModelFactory.createDefaultModel();

			Query query = QueryFactory.create(strQuery3);

			QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
			
			ResultSet results = (ResultSet) queryExecution.execSelect();
			ResultSetFormatter.out(System.out,  results);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Movie> searchByGenre(String genre) {
		List<Movie> movieList = new ArrayList<>();

		genreName = genre;
		try {
			Model model = ModelFactory.createDefaultModel();

		
		String searchByGenre = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX mo: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/MovieOntology#>\n"
				+ "PREFIX ro: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/RatingOntology#>\n"
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
				+ "SELECT DISTINCT ?TID ?title ?year ?actor ?director ?genre ?language ?country ?averageRating ?numVotes\n"
				+ "WHERE {\n"
					+ "SERVICE <http://35.193.133.153:3030/ds/query>"
					+ "{"
					    	+ "SERVICE <http://34.123.102.237:3030/ds/query>"
			    			+ "{"
			    					+ "?sample ro:hasTitleId ?TID;"
			    					+ "ro:numberOfVotes ?numVotes;"
			    					+ "ro:averageRating ?averageRating;"
			    					+ "ro:hasTitle ?title."
		    				+ "}"
				    	    + "?subject mo:hasTitleId ?TID."
			    			+ "?subject mo:hasActors ?actor."
			    			+ "?subject mo:hasDirector ?director."
			    			+ "?subject mo:hasGenre ?genre."
			    			+ "?subject mo:hasLanguages ?language."
			    			+ "?subject mo:hasCountry ?country."
			    			+ "?subject mo:hasYear ?year."
				    		+ "FILTER(xsd:string(?genre)=\"" + genre + "\"" + ").\n"
					+ "}"
				+"}"
				+ "order by desc (?year)";
		
		System.out.println(genre);
		
		Query query = QueryFactory.create(searchByGenre);
			
			
			QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
			
			ResultSet results = (ResultSet) queryExecution.execSelect();
			
			while(results.hasNext()) {
	            QuerySolution row = results.next();
	           
	            String id = row.getLiteral("?TID") != null ? row.getLiteral("?TID").toString() : "NULL";
	            String title = row.getLiteral("?title") != null ? row.getLiteral("?title").toString() : "NULL";
	            String year = row.getLiteral("?year") != null ? row.getLiteral("?year").toString() : "NULL";
	            String director = row.getLiteral("?director") != null ? row.getLiteral("?director").toString() : "NULL";
	            String actor = row.getLiteral("?actor") != null ? row.getLiteral("?actor").toString() : "NULL";
	            String _genre = row.getLiteral("?genre") != null ? row.getLiteral("?genre").toString() : "NULL";
	            String language = row.getLiteral("?language") != null ? row.getLiteral("?language").toString() : "NULL";
	            String country = row.getLiteral("?country") != null ? row.getLiteral("?country").toString() : "NULL";
	            String rating = row.getLiteral("?averageRating") != null ? row.getLiteral("?averageRating").toString() : "NULL";


	            Movie movie = new Movie(id, title, year, actor, director, _genre, language, country, rating);
	            movieList.add(movie);
	        }
			
			System.out.println(movieList);
			
			ResultSetFormatter.out(System.out,  results);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return movieList;
		
	}
	public static List<Movie> searchByCountry(String country) {
		List<Movie> movieList = new ArrayList<>();

		
		 String searchByCountry = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX mo: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/MovieOntology#>\n"
				+ "PREFIX ro: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/RatingOntology#>\n"
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
				+ "SELECT DISTINCT ?TID ?title ?year ?actor ?director ?genre ?language ?country ?averageRating ?numVotes\n"
				+ "WHERE {\n"
					+ "SERVICE <http://35.193.133.153:3030/ds/query>"
					+ "{"
					    	+ "SERVICE <http://34.123.102.237:3030/ds/query>"
			    			+ "{"
			    					+ "?sample ro:hasTitleId ?TID;"
			    					+ "ro:numberOfVotes ?numVotes;"
			    					+ "ro:averageRating ?averageRating;"
			    					+ "ro:hasTitle ?title."
		    				+ "}"
				    	    + "?subject mo:hasTitleId ?TID."
			    			+ "?subject mo:hasActors ?actor."
			    			+ "?subject mo:hasDirector ?director."
			    			+ "?subject mo:hasGenre ?genre."
			    			+ "?subject mo:hasLanguages ?language."
			    			+ "?subject mo:hasCountry ?country."
			    			+ "?subject mo:hasYear ?year."
			    			+ "FILTER(xsd:string(?country)=\"" + country + "\"" + ").\n"
					+ "}"
				+"}"
				+ "order by desc (?year)";
		try {
			Model model = ModelFactory.createDefaultModel();
			Query query = QueryFactory.create(searchByCountry);
			QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
			
			ResultSet results = (ResultSet) queryExecution.execSelect();
			
			while(results.hasNext()) {
	            QuerySolution row = results.next();
	           
	            String id = row.getLiteral("?TID") != null ? row.getLiteral("?TID").toString() : "NULL";
	            String title = row.getLiteral("?title") != null ? row.getLiteral("?title").toString() : "NULL";
	            String year = row.getLiteral("?year") != null ? row.getLiteral("?year").toString() : "NULL";
	            String director = row.getLiteral("?director") != null ? row.getLiteral("?director").toString() : "NULL";
	            String actor = row.getLiteral("?actor") != null ? row.getLiteral("?actor").toString() : "NULL";
	            String _genre = row.getLiteral("?genre") != null ? row.getLiteral("?genre").toString() : "NULL";
	            String language = row.getLiteral("?language") != null ? row.getLiteral("?language").toString() : "NULL";
	            String _country = row.getLiteral("?country") != null ? row.getLiteral("?country").toString() : "NULL";

	            String rating = row.getLiteral("?averageRating") != null ? row.getLiteral("?averageRating").toString() : "NULL";


	            Movie movie = new Movie(id, title, year, actor, director, _genre, language, _country, rating);
	            movieList.add(movie);
	        }
			
			ResultSetFormatter.out(System.out,  results);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return movieList;
		
	}
	public static List<Movie> searchByYear(String yearRange) {
		List<Movie> movieList = new ArrayList<>();

		
		int startYear = 0;
		int endYear = 0;
		startYear = getStartYear(yearRange);
		endYear = getEndYear(yearRange);
		String searchByYearRange = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX mo: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/MovieOntology#>\n"
				+ "PREFIX ro: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/RatingOntology#>\n"
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
				+ "SELECT DISTINCT ?TID ?title ?year ?actor ?director ?genre ?language ?country ?averageRating ?numVotes\n"
				+ "WHERE {\n"
					+ "SERVICE <http://35.193.133.153:3030/ds/query>"
					+ "{"
					    	+ "SERVICE <http://34.123.102.237:3030/ds/query>"
			    			+ "{"
			    					+ "?sample ro:hasTitleId ?TID;"
			    					+ "ro:numberOfVotes ?numVotes;"
			    					+ "ro:averageRating ?averageRating;"
			    					+ "ro:hasTitle ?title."
		    				+ "}"
				    	    + "?subject mo:hasTitleId ?TID."
			    			+ "?subject mo:hasActors ?actor."
			    			+ "?subject mo:hasDirector ?director."
			    			+ "?subject mo:hasGenre ?genre."
			    			+ "?subject mo:hasLanguages ?language."
			    			+ "?subject mo:hasCountry ?country."
			    			+ "?subject mo:hasYear ?year."
			    			+ "FILTER ((?year) >= " + startYear + "&& (?year) <= " + endYear + ")."
					+ "}"
				+"}"
				+ "order by desc (?year)";
		try {
			Model model = ModelFactory.createDefaultModel();
			
			Query query = QueryFactory.create(searchByYearRange);
			
			
			QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
			
			
			ResultSet results = (ResultSet) queryExecution.execSelect();
			
			while(results.hasNext()) {
	            QuerySolution row = results.next();
	           
	            String id = row.getLiteral("?TID") != null ? row.getLiteral("?TID").toString() : "NULL";
	            String title = row.getLiteral("?title") != null ? row.getLiteral("?title").toString() : "NULL";
	            String year = row.getLiteral("?year") != null ? row.getLiteral("?year").toString() : "NULL";
	            String director = row.getLiteral("?director") != null ? row.getLiteral("?director").toString() : "NULL";
	            String actor = row.getLiteral("?actor") != null ? row.getLiteral("?actor").toString() : "NULL";
	            String _genre = row.getLiteral("?genre") != null ? row.getLiteral("?genre").toString() : "NULL";
	            String language = row.getLiteral("?language") != null ? row.getLiteral("?language").toString() : "NULL";
	            String _country = row.getLiteral("?country") != null ? row.getLiteral("?country").toString() : "NULL";


	            String rating = row.getLiteral("?averageRating") != null ? row.getLiteral("?averageRating").toString() : "NULL";


	            Movie movie = new Movie(id, title, year, actor, director, _genre, language, _country, rating);
	            movieList.add(movie);
	        }
			
			ResultSetFormatter.out(System.out,  results);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return movieList;
		
	}

	public static int getStartYear(String yearRange) {
		int startYear = 0;
		String[] temp = yearRange.split("-",2);
		String temp1 = temp[0].trim();
		startYear = Integer.parseInt(temp1);
		return startYear;
	}
	
	public static int getEndYear(String yearRange) {
		int endYear = 0;
		String[] temp = yearRange.split("-",2);
		String temp1 = temp[1].trim();
		endYear = Integer.parseInt(temp1);
		return endYear;
	}
	public static List<Movie> searchByTitle(String titleName) {
		List<Movie> movieList = new ArrayList<>();
		String searchByTitle = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX mo: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/MovieOntology#>\n"
				+ "PREFIX ro: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/RatingOntology#>\n"
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
				+ "SELECT DISTINCT ?TID ?title ?year ?actor ?director ?genre ?language ?country ?averageRating ?numVotes\n"
				+ "WHERE {\n"
					+ "SERVICE <http://35.193.133.153:3030/ds/query>"
					+ "{"
					    	+ "SERVICE <http://34.123.102.237:3030/ds/query>"
			    			+ "{"
			    					+ "?sample ro:hasTitleId ?TID;"
			    					+ "ro:numberOfVotes ?numVotes;"
			    					+ "ro:averageRating ?averageRating;"
			    					+ "ro:hasTitle ?title."
		    				+ "}"
				    	    + "?subject mo:hasTitleId ?TID."
			    			+ "?subject mo:hasActors ?actor."
			    			+ "?subject mo:hasDirector ?director."
			    			+ "?subject mo:hasGenre ?genre."
			    			+ "?subject mo:hasLanguages ?language."
			    			+ "?subject mo:hasCountry ?country."
			    			+ "?subject mo:hasYear ?year."
			    			+ "FILTER CONTAINS((?title),\"" + titleName + "\"" + ")."
					+ "}"
				+"}"
				+ "order by desc (?year)";
		try {
			Model model = ModelFactory.createDefaultModel();
			
			Query query = QueryFactory.create(searchByTitle);
			
			
			QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
			
			
			ResultSet results = (ResultSet) queryExecution.execSelect();
			
			while(results.hasNext()) {
	            QuerySolution row = results.next();
	           
	            String id = row.getLiteral("?TID") != null ? row.getLiteral("?TID").toString() : "NULL";
	            String title = row.getLiteral("?title") != null ? row.getLiteral("?title").toString() : "NULL";
	            String year = row.getLiteral("?year") != null ? row.getLiteral("?year").toString() : "NULL";
	            String director = row.getLiteral("?director") != null ? row.getLiteral("?director").toString() : "NULL";
	            String actor = row.getLiteral("?actor") != null ? row.getLiteral("?actor").toString() : "NULL";
	            String _genre = row.getLiteral("?genre") != null ? row.getLiteral("?genre").toString() : "NULL";
	            String language = row.getLiteral("?language") != null ? row.getLiteral("?language").toString() : "NULL";
	            String _country = row.getLiteral("?country") != null ? row.getLiteral("?country").toString() : "NULL";


	            String rating = row.getLiteral("?averageRating") != null ? row.getLiteral("?averageRating").toString() : "NULL";


	            Movie movie = new Movie(id, title, year, actor, director, _genre, language, _country, rating);
	            movieList.add(movie);
	        }
			
			ResultSetFormatter.out(System.out,  results);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		return movieList;
	}
	
	public static List<Movie> searchByActor(String actor) {
		List<Movie> movieList = new ArrayList<>();
		String searchByActor = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX mo: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/MovieOntology#>\n"
				+ "PREFIX ro: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/RatingOntology#>\n"
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
				+ "SELECT DISTINCT ?TID ?title ?year ?actor ?director ?genre ?language ?country ?averageRating ?numVotes\n"
				+ "WHERE {\n"
					+ "SERVICE <http://35.193.133.153:3030/ds/query>"
					+ "{"
					    	+ "SERVICE <http://34.123.102.237:3030/ds/query>"
			    			+ "{"
			    					+ "?sample ro:hasTitleId ?TID;"
			    					+ "ro:numberOfVotes ?numVotes;"
			    					+ "ro:averageRating ?averageRating;"
			    					+ "ro:hasTitle ?title."
		    				+ "}"
				    	    + "?subject mo:hasTitleId ?TID."
			    			+ "?subject mo:hasActors ?actor."
			    			+ "?subject mo:hasDirector ?director."
			    			+ "?subject mo:hasGenre ?genre."
			    			+ "?subject mo:hasLanguages ?language."
			    			+ "?subject mo:hasCountry ?country."
			    			+ "?subject mo:hasYear ?year."
			    			+ "FILTER CONTAINS((?actor),\"" + actor + "\"" + ")."
					+ "}"
				+"}"
				+ "order by desc (?year)";
		try {
			Model model = ModelFactory.createDefaultModel();
			
			Query query = QueryFactory.create(searchByActor);
			
			
			QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
			
			
			ResultSet results = (ResultSet) queryExecution.execSelect();
			
			while(results.hasNext()) {
	            QuerySolution row = results.next();
	           
	            String id = row.getLiteral("?TID") != null ? row.getLiteral("?TID").toString() : "NULL";
	            String title = row.getLiteral("?title") != null ? row.getLiteral("?title").toString() : "NULL";
	            String year = row.getLiteral("?year") != null ? row.getLiteral("?year").toString() : "NULL";
	            String director = row.getLiteral("?director") != null ? row.getLiteral("?director").toString() : "NULL";
	            String _actor = row.getLiteral("?actor") != null ? row.getLiteral("?actor").toString() : "NULL";
	            String _genre = row.getLiteral("?genre") != null ? row.getLiteral("?genre").toString() : "NULL";
	            String language = row.getLiteral("?language") != null ? row.getLiteral("?language").toString() : "NULL";
	            String _country = row.getLiteral("?country") != null ? row.getLiteral("?country").toString() : "NULL";


	            String rating = row.getLiteral("?averageRating") != null ? row.getLiteral("?averageRating").toString() : "NULL";


	            Movie movie = new Movie(id, title, year, _actor, director, _genre, language, _country, rating);
	            movieList.add(movie);
	        }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		return movieList;
	}
	public static List<Movie> searchByDirector(String director) {
		List<Movie> movieList = new ArrayList<>();
		String searchByDirector = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX mo: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/MovieOntology#>\n"
				+ "PREFIX ro: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/RatingOntology#>\n"
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
				+ "SELECT DISTINCT ?TID ?title ?year ?actor ?director ?genre ?language ?country ?averageRating ?numVotes\n"
				+ "WHERE {\n"
					+ "SERVICE <http://35.193.133.153:3030/ds/query>"
					+ "{"
					    	+ "SERVICE <http://34.123.102.237:3030/ds/query>"
			    			+ "{"
			    					+ "?sample ro:hasTitleId ?TID;"
			    					+ "ro:numberOfVotes ?numVotes;"
			    					+ "ro:averageRating ?averageRating;"
			    					+ "ro:hasTitle ?title."
		    				+ "}"
				    	    + "?subject mo:hasTitleId ?TID."
			    			+ "?subject mo:hasActors ?actor."
			    			+ "?subject mo:hasDirector ?director."
			    			+ "?subject mo:hasGenre ?genre."
			    			+ "?subject mo:hasLanguages ?language."
			    			+ "?subject mo:hasCountry ?country."
			    			+ "?subject mo:hasYear ?year."
			    			+ "FILTER CONTAINS((?director),\"" + director + "\"" + ")."
					+ "}"
				+"}"
				+ "order by desc (?year)";
		try {
			Model model = ModelFactory.createDefaultModel();
			
			Query query = QueryFactory.create(searchByDirector);
			
			
			QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
			
			
			ResultSet results = (ResultSet) queryExecution.execSelect();
			
			while(results.hasNext()) {
	            QuerySolution row = results.next();
	           
	            String id = row.getLiteral("?TID") != null ? row.getLiteral("?TID").toString() : "NULL";
	            String title = row.getLiteral("?title") != null ? row.getLiteral("?title").toString() : "NULL";
	            String year = row.getLiteral("?year") != null ? row.getLiteral("?year").toString() : "NULL";
	            String _director = row.getLiteral("?director") != null ? row.getLiteral("?director").toString() : "NULL";
	            String _actor = row.getLiteral("?actor") != null ? row.getLiteral("?actor").toString() : "NULL";
	            String _genre = row.getLiteral("?genre") != null ? row.getLiteral("?genre").toString() : "NULL";
	            String language = row.getLiteral("?language") != null ? row.getLiteral("?language").toString() : "NULL";
	            String _country = row.getLiteral("?country") != null ? row.getLiteral("?country").toString() : "NULL";


	            String rating = row.getLiteral("?averageRating") != null ? row.getLiteral("?averageRating").toString() : "NULL";


	            Movie movie = new Movie(id, title, year, _actor, _director, _genre, language, _country, rating);
	            movieList.add(movie);
	        }
			
			ResultSetFormatter.out(System.out,  results);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		return movieList;
	}
	public static String searchActorDetails(String _actor) {
		String ans = "No records found";
		 String actor = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX mo: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/MovieOntology#>\n"
				+ "PREFIX ao: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/ActorOntology#>\n"
				+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
				+ "SELECT ?actorName ?dob ?pob ?bio \n"
				+ "WHERE {\n"
					+ "SERVICE <http://35.223.121.153:3030/ds/query>"
					+ "{"
						+ "SELECT ?actorName ?dob ?pob ?bio \n"
						+ "WHERE {\n"
							+ "?subject ao:hasName ?actorName."
							+ "?subject ao:hasDateOfBirth ?dob."
							+ "?subject ao:hasPlaceOfBirth ?pob."
							+ "?subject rdfs:comment ?bio."
							+ "FILTER CONTAINS((?actorName),\"" + _actor + "\"" + ")."
						+ "}"
					+ "}"
				+"}";
		
		try {
			Model model = ModelFactory.createDefaultModel();
			
			Query query = QueryFactory.create(actor);
			
			
			QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
			
			
			ResultSet results = (ResultSet) queryExecution.execSelect();
			
			 ans = ResultSetFormatter.asText(results);
			
			ResultSetFormatter.out(System.out,  results);
			
			
			 
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return ans;
		
	}
	
	
	
}
