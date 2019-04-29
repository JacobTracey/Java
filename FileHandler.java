package MinecraftDrugs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class FileHandler
{	
	static int MAX_ACCOUNTS = 20000;
	static int MAX_STATS = 500;
	static String test;
	static String tag[] = new String[500];
	
	public boolean fileExists(File file)
	{
		if(!file.exists()) return false;
		return true;
	}
	
	public void fileCreate(File dir, File fileName, Player player)
	{
		ConsoleCommandSender console = player.getServer().getConsoleSender();
		
		if(!dir.isDirectory()) dir.mkdirs();
		try
		{
			fileName.createNewFile();
			return;
		}
		catch(IOException e)
		{
			console.getServer().broadcastMessage("Error: IOExeption #1. <MinecraftDrugs.FileHandler.createFile");
		}
		catch(Exception e)
		{
			console.getServer().broadcastMessage("Error: Generic Exception #1. <MinecraftDrugs.FileHandler.createFile");
			e.printStackTrace((PrintStream) console);
		}
		return;
	}
	
	public void fileSave(File file, Map<String, String> stat) throws IOException
	{
		FileWriter writer = new FileWriter(file);
		FileReader read = new FileReader(file);
		BufferedReader reader = new BufferedReader(read);
		
		stat.keySet().toArray(tag);
		
		System.out.println(tag[0] + tag[1]);
		
		for(int i = 0; i < stat.size(); i++)
		{
			writer.write(tag[i] + ":" + stat.get(tag[i]) + "\n");
		}
		writer.close();
		reader.close();
		return;
	}
	
	public HashMap<String, String> fileLoad(File file, int fileLines, Player player) throws IOException
	{
		HashMap<String, String> map = new HashMap<String, String>();
		FileReader read = new FileReader(file);
		BufferedReader reader = new BufferedReader(read);
		
		String str = null;
		
		for(int i = 0; i < fileLines; i++)
		{
			if(keyValue(i) == null) break;
			str = reader.readLine();
			
			for(int ii = 0; ii < str.length(); ii++)
			{
				if(ii == str.length() - 1) str = "<NO VALUE>";
				if(str.charAt(ii) == ':' && ii < str.length())
				{
					str = str.substring(ii + 1, str.length());
					break;
				}
				else if(ii == str.length() - 1) break;
				continue;
			}
			
			map.put(keyValue(i), str);
		}
		reader.close();
		return map;
	}
	
	public String keyValue(int key)
	{
		switch(key)
		{
			case 0: return "Password";
			default: return null;
		}
	}
}