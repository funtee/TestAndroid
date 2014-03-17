package com.test.Android.DB;

public class PoseBd {
   public String imgUrl;
   public String poseId;
   
   public void setPoseId(String id){
	   this.poseId=id;
   }
   
   public void setImgUrl(String img){
	   this.imgUrl=img;
   }
   
   public String getImgUrl(){
	   return this.imgUrl;
   }
   
   public String getPoseId(){
	   return this.poseId;
   }
}
