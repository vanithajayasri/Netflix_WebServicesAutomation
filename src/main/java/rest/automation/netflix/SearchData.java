package rest.automation.netflix;

public class SearchData {
	
	SearchRequest searchRequest = new SearchRequest();
	SearchResponse searchResponse = new SearchResponse();
	
	public SearchRequest getSearchRequest() {
		return searchRequest;
	}
	public void setSearchRequest(SearchRequest searchRequest) {
		this.searchRequest = searchRequest;
	}
	public SearchResponse getSearchResponse() {
		return searchResponse;
	}
	public void setSearchResponse(SearchResponse searchResponse) {
		this.searchResponse = searchResponse;
	}
	
	
	

}
