package kr.co.bit.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.bit.company.vo.CompanyFileVO;
import kr.co.bit.company.vo.CompanyInfoVO;
import kr.co.bit.hotel.vo.RoomVO;

@Component("fileUtils")
public class FileUtils {
    
	private static final String filePath = "C:/Users/User/workspace/Hotel-reserve-project/src/main/webapp/resources/photo/";
     
	public Object[] saveFile(String hotelName, HttpServletRequest request) throws Exception {
		
		Object[] object = null;
		List<CompanyFileVO> list = new ArrayList<>();
		CompanyFileVO companyFileVO = null;
		CompanyInfoVO companyInfoVO = null;
		
    	String oriFileName = null;
    	String oriFileExtension = null;
    	String newFileName = null;
    	
    	File file = new File(filePath);
    	if(file.exists() == false){
            file.mkdirs();
        }
    	
    	MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		MultipartFile multipartFile = null;

		Iterator<String> iter = multipartHttpServletRequest.getFileNames();
		
		while(iter.hasNext()){
			
			multipartFile = multipartHttpServletRequest.getFile(iter.next());
			 
				if(multipartFile.isEmpty() == false){
					
				 	oriFileName = multipartFile.getOriginalFilename();
		            oriFileExtension = oriFileName.substring(oriFileName.lastIndexOf("."));
		            newFileName = CommonUtils.getRandomString()+oriFileExtension;
		            
		            file = new File(filePath+newFileName);
		            multipartFile.transferTo(file);
		            
					if (multipartFile.getName().equals("mainfile")) {
						
						companyInfoVO = new CompanyInfoVO();
						companyInfoVO.setHotelName(hotelName);
						companyInfoVO.setOriMainFile(oriFileName);
						companyInfoVO.setNewMainFile(newFileName);
					
					} else {
						
						companyFileVO = new CompanyFileVO();
						companyFileVO.setHotelName(hotelName);
						companyFileVO.setOriFile(oriFileName);
						companyFileVO.setNewFile(newFileName);
	
						list.add(companyFileVO);
					}
		            
		        }
		}
		object = new Object[]{list, companyInfoVO};
    	
    	return object;
    }
	
public RoomVO saveRoomFile(String hotelName, HttpServletRequest request) throws Exception {
		
		RoomVO roomVO = null;
		
    	String oriFileName = null;
    	String oriFileExtension = null;
    	String newFileName = null;
    	
    	File file = new File(filePath);
    	if(file.exists() == false){
            file.mkdirs();
        }
    	
    	MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		MultipartFile multipartFile = null;

		Iterator<String> iter = multipartHttpServletRequest.getFileNames();
		
		while(iter.hasNext()){
			
			multipartFile = multipartHttpServletRequest.getFile(iter.next());
			 
				if(multipartFile.isEmpty() == false){
					
				 	oriFileName = multipartFile.getOriginalFilename();
		            oriFileExtension = oriFileName.substring(oriFileName.lastIndexOf("."));
		            newFileName = CommonUtils.getRandomString()+oriFileExtension;
		            
		            file = new File(filePath+newFileName);
		            multipartFile.transferTo(file);     
			
		            roomVO = new RoomVO();
		            roomVO.setOriRoomFile(oriFileName);
		            roomVO.setNewRoomFile(newFileName);            
		        }
		}
	
    	return roomVO;
    }
}

