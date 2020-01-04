package Main;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {
    final String[] KEYWORDS = { //50个关键字
            "abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else",
            "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import",
            "instanceof", "int", "interface", "long", "native",
            "new", "package", " private", " protected", "public",
            "return", "strictfp", "short", "static", "super",
            "switch", "synchronized", "this", "throw", "throws",
            "transient", "try", "void", "volatile", "while"
    };
	public int SearchKeyword(File file1) {
		int count=0;
		String line = null;
		try {
			FileReader ReaderFile;
			ReaderFile = new FileReader(file1);
			char[] a = new char[10000];
			ReaderFile.read(a);
			line=String.valueOf(a);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    String[] wordList = line.replaceAll("\\W", " ").split(" ");
	    for (int i = 0; i < wordList.length; i++) {
	    	for (int j = 0; j < 50; j++) {
	            if (wordList[i].equals(KEYWORDS[j])) { //循环判断
	               count++;
	            }
	        }
	    }

		return count;
	}
	public String Regularsearch(String line,String pattern) {
		String str=null;
	    Pattern r = Pattern.compile(pattern);
	 
	    // 现在创建 matcher 对象
	    Matcher m = r.matcher(line);
	    while (m.find()) {
	    	 str=str+m.group();
	    }
		return str;
	}
	
}
