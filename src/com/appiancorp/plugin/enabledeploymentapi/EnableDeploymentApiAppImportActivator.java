package com.appiancorp.plugin.enabledeploymentapi;

import java.io.InputStream;

import org.apache.log4j.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.appiancorp.suiteapi.ix.ImportExportService;
import com.appiancorp.common.config.ApplicationContextHolder;

public class EnableDeploymentApiAppImportActivator implements BundleActivator {

  private static final Logger LOG = Logger.getLogger(EnableDeploymentApiAppImportActivator.class);
  private static final String PATH_TO_APP = "resources/ExternalDeploymentApiHelper.zip";
  private InputStream getAppResourceAsStream() {
    return EnableDeploymentApiAppImportActivator.class.getClassLoader().getResourceAsStream(
        EnableDeploymentApiAppImportActivator.PATH_TO_APP);
  }

  @Override
  public void start(BundleContext bundleContext) {
    try (InputStream appInputStream = getAppResourceAsStream()) {
      ImportExportService ies = ApplicationContextHolder.getBean(ImportExportService.class);
      LOG.info("Importing EnableDeploymentAPI package");
      ies.importPackage(appInputStream);
      LOG.info("App imported successfully");
    } catch (Exception e) {
      LOG.error("Failed to import... ", e);
    }
  }

  @Override
  public void stop(BundleContext bundleContext) {
    LOG.info("Done, undeployed plugin");
  }
}
