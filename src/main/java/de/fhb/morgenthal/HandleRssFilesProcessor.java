package de.fhb.morgenthal;

import de.fhb.morgenthal.utils.RSSFilesUtils;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.io.File;

public class HandleRssFilesProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		File latestCH = RSSFilesUtils.getLatestRssFile("CH");
		File latestDE = RSSFilesUtils.getLatestRssFile("DE");
		File latestAT = RSSFilesUtils.getLatestRssFile("AT");
		File rssFile = new File(MyRouteBuilder.RSSFile);
		if(rssFile!=null && rssFile.exists())
			rssFile.delete();
		if(latestCH!= null && latestCH.exists())
			latestCH.delete();
		if(latestDE!= null && latestDE.exists())
			latestDE.delete();
		if(latestAT!= null && latestAT.exists())
			latestAT.delete();
	}

}
