package org.jboss.windup.graph.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.jboss.windup.graph.model.resource.TempArchiveResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TempFileArchiveEntryDao extends BaseDao<TempArchiveResource> {

	private static Logger LOG = LoggerFactory.getLogger(TempFileArchiveEntryDao.class);
	
	public File asFile(TempArchiveResource resource) {
		return new File(resource.getFilePath());
	}

	public InputStream asInputStream(TempArchiveResource entry) throws IOException {
		//try and read the XML...
		FileInputStream fis = new FileInputStream(asFile(entry));
		return fis;
	}
	
	public TempFileArchiveEntryDao() {
		super(TempArchiveResource.class);
	}
}