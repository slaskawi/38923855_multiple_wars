package org.infinispan.tutorial.simple.map;

import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.infinispan.configuration.cache.CacheMode;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.configuration.global.GlobalConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;

@Singleton
@Startup
public class InfinispanMap {

   private static final Logger logger = LogManager.getLogManager().getLogger("test");

   private DefaultCacheManager cacheManager;

   @PostConstruct
   public void init() {
      logger.severe("Init start");

      GlobalConfigurationBuilder gcb = new GlobalConfigurationBuilder();
      gcb.globalJmxStatistics().enabled(false).allowDuplicateDomains(true);
      gcb.transport().defaultTransport();

      ConfigurationBuilder builder = new ConfigurationBuilder();
      builder.clustering().cacheMode(CacheMode.DIST_SYNC).expiration().lifespan(24l, TimeUnit.HOURS);

      builder.clustering().stateTransfer().awaitInitialTransfer(false);
      builder.clustering().hash().numOwners(2);

      cacheManager = new DefaultCacheManager(gcb.build(), builder.build());

      cacheManager.getCache().put("test", "test");

      logger.severe("Init end");
   }

   @PreDestroy
   public void cleanup() {
      logger.severe("Cleanup start");
      cacheManager.getCache().get("test");
      cacheManager.stop();
      logger.severe("Cleanup stop");
   }

}
