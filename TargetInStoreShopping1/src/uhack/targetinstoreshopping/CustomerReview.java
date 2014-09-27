
package uhack.targetinstoreshopping;

import java.util.List;

public class CustomerReview{
   	private List consolidatedRatableAttributes;
   	private List reviews;
   	private String consolidatedOverallRating;
   	private String totalPages;
   	private String totalReviews;

 	public List getConsolidatedRatableAttributes(){
		return this.consolidatedRatableAttributes;
	}
	public void setConsolidatedRatableAttributes(List consolidatedRatableAttributes){
		this.consolidatedRatableAttributes = consolidatedRatableAttributes;
	}
 	public List getReviews(){
		return this.reviews;
	}
	public void setReviews(List reviews){
		this.reviews = reviews;
	}
 	public String getConsolidatedOverallRating(){
		return this.consolidatedOverallRating;
	}
	public void setConsolidatedOverallRating(String consolidatedOverallRating){
		this.consolidatedOverallRating = consolidatedOverallRating;
	}
 	public String getTotalPages(){
		return this.totalPages;
	}
	public void setTotalPages(String totalPages){
		this.totalPages = totalPages;
	}
 	public String getTotalReviews(){
		return this.totalReviews;
	}
	public void setTotalReviews(String totalReviews){
		this.totalReviews = totalReviews;
	}
}
