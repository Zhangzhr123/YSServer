package com.utils;

import java.io.*;
import java.util.Date;

/**
 * 文件工具
 * 
 * @author sunmc
 * @since 2017/11/23
 *
 */
public class FileUtil {

	/**
	 * @param str
	 * @return filename
	 */
	public static String string2File(String str){
		String filename = "";
		if(StringUtil.isNullOrEmpty(str)){
			str = " ";
		}
		PrintStream ps = null;
		try{
			//将附件名保存至文件--避免因附件过多导致附件名总长度超长；
			String fname = new Date().getTime() + ".txt";
			String spath = DateUtil.nowYMD() + "/";
			File file = new File(Common.UP_LOAD_PATH + spath, fname);
			if(!file.exists()){
				file.getParentFile().mkdirs();
			}
			ps = new PrintStream(new FileOutputStream(file));
			while(str.length() > 1000){
				String ws = str.substring(0, 1000);
				ps.append(ws);
				str = str.substring(1000);
			}
			ps.append(str);

			filename = spath + fname;
		}catch (Exception e){
			e.printStackTrace();
			LogUtil.writeLog(e);
		}finally {
			try {
				if(ps != null){
					ps.close();
				}
			}catch (Exception e){
				e.printStackTrace();
				LogUtil.writeLog(e);
			}
		}
		return filename;
	}
	public static String file2String(String filepath){
		File file1 = new File(Common.UP_LOAD_PATH + filepath);
		String text = "";
		BufferedReader br = null;
		try{
			if(file1.exists()){
				br = new BufferedReader(new FileReader(file1));
				String temp = null;
				while ((temp = br.readLine()) != null){
					text += temp;
				}
			}else{
				text = filepath;
			}
		}catch(Exception e){
			e.printStackTrace();
			LogUtil.writeLog(e);
		}finally {
			try {
				if(br != null){
					br.close();
				}
			}catch (Exception e){
				e.printStackTrace();
				LogUtil.writeLog(e);
			}
		}
		return text;
	}
}
