/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lockdown.traveller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class allPath {
    private int v;



	Map<String, ArrayList<String>> adjList;
	ArrayList<ArrayList<String>> arrt;

	public allPath(ArrayList<String> arr)
	{

		this.v = arr.size();

		
		initAdjList(arr);
	}

	
	
	private void initAdjList(ArrayList<String> ar)
	{
		adjList = new HashMap<String, ArrayList<String>>();

		for (int i = 0; i < v; i++) {
			adjList.put(ar.get(i),new ArrayList<String>());
		}
	}

	
	public void addEdge(String u, String v)
	{
		
		adjList.get(u).add(v);
		adjList.get(v).add(u);
	}


	public ArrayList<ArrayList<String>> printAllPaths(String s, String d,ArrayList<String> arr)
	{
	
		Map<String, Integer> isVisited = new HashMap<String,Integer>();
		for (int i = 0; i < v; i++) {
			isVisited.put(arr.get(i),0);
		}
		ArrayList<String> pathList = new ArrayList<>();

	
		pathList.add(s);

		arrt=new ArrayList<ArrayList<String>>();
		printAllPathsUtil(s, d, isVisited, pathList);
		//System.out.println(arrt);
                return arrt;
	}


	private void printAllPathsUtil(String u, String d,Map<String,Integer> isVisited,ArrayList<String> localPathList)
	{

		if (u.equals(d)) {
			//System.out.println(localPathList);
			ArrayList<String> newarr=new ArrayList<String>();
			for (int i = 0; i < localPathList.size(); i++) {
			    newarr.add(localPathList.get(i));
		    }
			arrt.add(newarr);
		
			return;
		}

		
	
		isVisited.put(u,1);

	
		for (String i : adjList.get(u)) {
			if (isVisited.get(i)==0) {
				
				localPathList.add(i);
				printAllPathsUtil(i, d, isVisited, localPathList);

				
				localPathList.remove(i);
			}
		}

	
		isVisited.put(u,0);
	}

    
}
