package main;

public class SPARQLQuery {
	
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
	
	public static String searchByGenre(String genreName) {
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
				    		+ "FILTER(xsd:string(?genre)=\"" + genreName + "\"" + ").\n"
					+ "}"
				+"}"
				+ "order by desc (?year)";
		return searchByGenre;
	}
	
	public static String searchByCountry(String countryName) {
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
			    			+ "FILTER(xsd:string(?country)=\"" + countryName + "\"" + ").\n"
					+ "}"
				+"}"
				+ "order by desc (?year)";
		return searchByCountry;
	}
	
	public static String searchByTitle(String titleName) {
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
		return searchByTitle;
	}
	
	public static String searchByActor(String actorName) {
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
			    			+ "FILTER CONTAINS((?actor),\"" + actorName + "\"" + ")."
					+ "}"
				+"}"
				+ "order by desc (?year)";
		return searchByActor;
	}
	
	public static String searchByDirector(String directorName) {
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
			    			+ "FILTER CONTAINS((?director),\"" + directorName + "\"" + ")."
					+ "}"
				+"}"
				+ "order by desc (?year)";
		return searchByDirector;
	}
	
	public static String searchByYearRange(String yearRange) {
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
		return searchByYearRange;
	}

}
