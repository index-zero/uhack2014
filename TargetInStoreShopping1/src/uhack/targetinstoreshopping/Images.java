
package uhack.targetinstoreshopping;

import java.util.List;

public class Images{
   	private List alternateImages;
   	private List primaryImage;
   	private List swatchImages;
   	private List thumbnailImage;
   	private String source;

 	public List getAlternateImages(){
		return this.alternateImages;
	}
	public void setAlternateImages(List alternateImages){
		this.alternateImages = alternateImages;
	}
 	public List getPrimaryImage(){
		return this.primaryImage;
	}
	public void setPrimaryImage(List primaryImage){
		this.primaryImage = primaryImage;
	}
 	public List getSwatchImages(){
		return this.swatchImages;
	}
	public void setSwatchImages(List swatchImages){
		this.swatchImages = swatchImages;
	}
 	public List getThumbnailImage(){
		return this.thumbnailImage;
	}
	public void setThumbnailImage(List thumbnailImage){
		this.thumbnailImage = thumbnailImage;
	}
 	public String getSource(){
		return this.source;
	}
	public void setSource(String source){
		this.source = source;
	}
}
