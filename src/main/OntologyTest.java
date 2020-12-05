package main;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class OntologyTest {
	
	static String genreName = "Crime";
	static String strQuery1 = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
			+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
			+ "PREFIX mo: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/MovieOntology#>\n"
			+ "PREFIX ro: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/RatingOntology#>\n"
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
			+ "SELECT ?TID ?Title ?year ?Actor ?director ?genre ?language \n"
			+ "WHERE {\n"
				+ "SERVICE <http://35.193.133.153:3030/ds/query>"
				+ "{"
			    	+ "SELECT ?subject ?TID ?Title ?year ?Actor ?director ?genre ?language\n" 
			    	+ "WHERE {\n"
			    	    + "?subject mo:hasTitleId ?TID;\n"
			    	    + "mo:hasTitle ?Title;\n"
		    			+ "mo:hasActors ?Actor;\n"
		    			+ "mo:hasDirector ?director;\n"
		    			+ "mo:hasGenre ?genre;\n"
		    			+ "mo:hasLanguages ?language;\n"
		    			+ "mo:hasYear ?year.\n"
		    			//+ "FILTER(xsd:string(?genre)=\"" + genreName + "\"" + ").\n"
		    			+"FILTER((?Title)=\"Il pensionante\")."
		    		+"}"
			    	+ "order by desc (?year)"
			    +"}"
			+"}";
			
//	static String strQuery2 = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
//			+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
//			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
//			+ "PREFIX mo: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/MovieOntology#>\n"
//			+ "PREFIX ro: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/RatingOntology#>\n"
//			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
//			+ "SELECT ?TID ?title ?year ?object ?director ?genre ?language ?averageRating ?numVotes\n"
//			+ "WHERE {\n"
//				+ "SERVICE <http://35.193.133.153:3030/ds/query>"
//				+ "{"
//			    	+ "SELECT ?subject ?TID ?year ?object ?director ?genre ?language\n" 
//			    	+ "WHERE {\n"
//			    	    + "?subject mo:hasTitleId ?TID;\n"
//			    			+ "mo:hasActor ?object;\n"
//			    			+ "mo:hasDirector ?director;\n"
//			    			+ "mo:hasGenre ?genre;\n"
//			    			+ "mo:hasLanguage ?language;\n"
//			    			+ "mo:hasYear ?year.\n"
//				    			+ "SERVICE <http://34.123.102.237:3030/ds/query>"
//				    			+ "{"
//				    				+ "SELECT ?sample ?TitleID ?title ?numVotes ?averageRating \n"
//				    			    + "WHERE {\n"
//			    					+ "?sample ro:hasTitleId ?TitleID;"
//			    					+ "ro:numberOfVotes ?numVotes;"
//			    					+ "ro:averageRating ?averageRating;"
//			    					+ "ro:hasTitle ?title."
//			    					+ "FILTER(xsd:string(?TitleID))."
//			    					+ "}"
//			    				+ "}"
//			    		+ "FILTER(?TID=?TitleID)."
//			    		+ "FILTER(xsd:string(?genre)=\"" + genreName + "\"" + ").\n"
//			    	+ "}\n"
//			    	+ "order by desc (?year)"
//				+ "}"
//			+"}";
//	static String strQuery2 = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
//			+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
//			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
//			+ "PREFIX mo: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/MovieOntology#>\n"
//			+ "PREFIX ro: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/RatingOntology#>\n"
//			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
//			+ "SELECT ?TID ?title ?year ?object ?director ?genre ?language ?averageRating ?numVotes\n"
//			+ "WHERE {\n"
//				+ "SERVICE <http://35.193.133.153:3030/ds/query>"
//				+ "{"
//			    	+ "SELECT ?subject ?TID ?year ?object ?director ?genre ?language\n" 
//			    	+ "WHERE {\n"
//				    	+ "SERVICE <http://34.123.102.237:3030/ds/query>"
//		    			+ "{"
//		    				+ "SELECT ?sample ?TID ?title ?numVotes ?averageRating\n" 
//		    				+ "WHERE {\n"
//		    					+ "?sample ro:hasTitleId ?TID;"
//		    					+ "ro:numberOfVotes ?numVotes;"
//		    					+ "ro:averageRating ?averageRating;"
//		    					+ "ro:hasTitle ?title."
//		    				+ "}"
//	    				+ "}"
//			    	    + "?subject mo:hasTitleId ?TID;"
//		    			+ "mo:hasActor ?object;"
//		    			+ "mo:hasDirector ?director;"
//		    			+ "mo:hasGenre ?genre;"
//		    			+ "mo:hasLanguage ?language;"
//		    			+ "mo:hasYear ?year."
//			    		+ "FILTER(xsd:string(?genre)=\"" + genreName + "\"" + ").\n"
//			    	+ "}\n"
//			    	//+ "order by desc (?year)"
//				+ "}"
//			+"}";
	
	static String strQuery2 = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
			+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
			+ "PREFIX mo: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/MovieOntology#>\n"
			+ "PREFIX ro: <http://www.semanticweb.org/niketbhave/ontologies/2020/10/RatingOntology#>\n"
			+ "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n"
			+ "SELECT ?TID ?title ?year ?object ?director ?genre ?language  ?rating ?tID \n"
			+ "WHERE {\n"
				+ "SERVICE <http://35.193.133.153:3030/ds/query>"
				+ "{"
			    	+ "SELECT ?subject ?TID ?year ?object ?director ?genre ?language \n" 
			    	+ "WHERE {\n"
			    	    + "?subject mo:hasTitleId ?TID;\n"
			    			+ "mo:hasActor ?object;\n"
			    			+ "mo:hasDirector ?director;\n"
			    			+ "mo:hasGenre ?genre;\n"
			    			+ "mo:hasLanguage ?language;\n"
			    			+ "mo:hasYear ?year.\n"
				    			+ "SERVICE <http://34.123.102.237:3030/ds/query>"
				    			+ "{"
				    				+ "SELECT ?sample \n"
				    			    + "WHERE {\n"
			    					+ "?sample ?predicate ?tID."
				    			    + "?sample ro:hasAverageRating ?rating."
			    					
			    					
			    					+ "}"
			    				+ "}"
			    					
			    	
			    	+ "}\n"
			    	+ "order by desc (?year)"
				+ "}"
			+"}";
	
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
		try {
			Model model = ModelFactory.createDefaultModel();
			Query query = QueryFactory.create(strQuery2);
			QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
			
			ResultSet results = queryExecution.execSelect();
			ResultSetFormatter.out(System.out, results);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
