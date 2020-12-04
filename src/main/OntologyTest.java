package main;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;

public class OntologyTest {
	
	public static void main(String[] args) {
		
		String location = "http://35.223.121.153:3030/ds/query";
		String strQuery = "SELECT (COUNT(?s) as ?sCount)"
				+ "WHERE"
				+ "{"
				+ "?s ?p ?o."
				+ "}";
		
		OntologyTest LO = new OntologyTest();
		LO.load(location, strQuery);
		
	}
	
	private void load(String loc, String Qry) {
		try {
			QueryExecution q = QueryExecutionFactory.sparqlService(loc, Qry);
			ResultSet results = q.execSelect();
			ResultSetFormatter.out(System.out, results);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
