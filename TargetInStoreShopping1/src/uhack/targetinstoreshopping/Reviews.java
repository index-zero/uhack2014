
package uhack.targetinstoreshopping;

import java.util.List;

public class Reviews{
   	private List ratableAttributes;
   	private String city;
   	private String customerId;
   	private String datePosted;
   	private String helpfulVotes;
   	private String overallRating;
   	private String review;
   	private String reviewKey;
   	private String screenName;
   	private String state;
   	private String title;
   	private String totalComments;
   	private String totalVotes;

 	public List getRatableAttributes(){
		return this.ratableAttributes;
	}
	public void setRatableAttributes(List ratableAttributes){
		this.ratableAttributes = ratableAttributes;
	}
 	public String getCity(){
		return this.city;
	}
	public void setCity(String city){
		this.city = city;
	}
 	public String getCustomerId(){
		return this.customerId;
	}
	public void setCustomerId(String customerId){
		this.customerId = customerId;
	}
 	public String getDatePosted(){
		return this.datePosted;
	}
	public void setDatePosted(String datePosted){
		this.datePosted = datePosted;
	}
 	public String getHelpfulVotes(){
		return this.helpfulVotes;
	}
	public void setHelpfulVotes(String helpfulVotes){
		this.helpfulVotes = helpfulVotes;
	}
 	public String getOverallRating(){
		return this.overallRating;
	}
	public void setOverallRating(String overallRating){
		this.overallRating = overallRating;
	}
 	public String getReview(){
		return this.review;
	}
	public void setReview(String review){
		this.review = review;
	}
 	public String getReviewKey(){
		return this.reviewKey;
	}
	public void setReviewKey(String reviewKey){
		this.reviewKey = reviewKey;
	}
 	public String getScreenName(){
		return this.screenName;
	}
	public void setScreenName(String screenName){
		this.screenName = screenName;
	}
 	public String getState(){
		return this.state;
	}
	public void setState(String state){
		this.state = state;
	}
 	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
 	public String getTotalComments(){
		return this.totalComments;
	}
	public void setTotalComments(String totalComments){
		this.totalComments = totalComments;
	}
 	public String getTotalVotes(){
		return this.totalVotes;
	}
	public void setTotalVotes(String totalVotes){
		this.totalVotes = totalVotes;
	}
}
