package com.clover.game.util;

/**
 * @author admin
 * ¼ì²âÅö×²
 *
 */
public class RamCheck {

//	public static boolean ifRam(Object o1, Object o2){
//		return false;
//	}
	public static boolean ifRam(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
		if(x1 <= x4 && y1 <= y4 && x2 >= x3 && y2 >= y3){
			return true;
		}
		return false;
	}
}
