def pluginList = new ArrayList(Jenkins.instance.pluginManager.plugins)

new File('/tmp/plugins.txt').withWriter('UTF-8'){ writer ->
  try{
    pluginList.sort{it.getDisplayName()}.each{
      plugin ->
        writer << ("${plugin.getShortName()}:${plugin.getVersion()}\n")
    }
  } finally {
      writer.close()
    }
  }