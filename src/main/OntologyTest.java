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
	static String countryName = "USA";
	static String titleName = "Il pensionante";
	static String actorName = "Arthur";
	static String directorName = "Alfred Hitchcock";
	static String yearRange = "1920 - 1930";
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
		searchBy = SPARQLQuery.searchByTitle(titleName);
		try {
			Model model = ModelFactory.createDefaultModel();
			Query query = QueryFactory.create(searchBy);
			QueryExecution queryExecution = QueryExecutionFactory.create(query, model);
			
			ResultSet results = queryExecution.execSelect();
			ResultSetFormatter.out(System.out, results);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
