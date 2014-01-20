package me.lostvine.olibro.fjnl;

public enum Paths
{
  PLUGIN_DIS("Plugin Disabled"), PERM_JOIN("fakejoinnleave join Permission"), PERM_LEAVE("fakejoinnleave leave Permission");

  private String path;

  private Paths(String path) {
    this.path = path;
  }

  public String getPath() {
    return this.path;
  }
}