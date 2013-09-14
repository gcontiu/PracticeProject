The client needs to get its customize web page appearance according to who he is.
Customize font, e-mail, logo image

The custom appearance should be plugged in using the "Plugin" EA Design Pattern of M.Fowler.

A plugin factory is used for the client to obtain the right plugin.

The plugin configuration is centralized (plugins.properties) and the values are the concrete plugin absolute class names.

