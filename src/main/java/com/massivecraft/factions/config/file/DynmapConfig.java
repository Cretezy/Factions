package com.massivecraft.factions.config.file;

import com.google.common.collect.ImmutableMap;
import com.massivecraft.factions.integration.dynmap.DynmapStyle;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"FieldCanBeLocal", "InnerClassMayBeStatic", "BooleanMethodIsAlwaysInverted"})
public class DynmapConfig {
    public class Dynmap {
        // Should the dynmap integration be used?
        private boolean enabled = true;

        // Name of the Factions layer
        private String layerName = "Factions";

        // Should the layer be visible per default
        private boolean layerVisible = true;

        // Ordering priority in layer menu (low goes before high - default is 0)
        private int layerPriority = 2;

        // (optional) set minimum zoom level before layer is visible (0 = default, always visible)
        private int layerMinimumZoom = 0;

        // Format for popup - substitute values for macros
        private String description =
                "<div class=\"infowindow\">\n"
                        + "<span style=\"font-weight: bold; font-size: 150%;\">%name%</span><br>\n"
                        + "<span style=\"font-style: italic; font-size: 110%;\">%description%</span><br>"
                        + "<br>\n"
                        + "<span style=\"font-weight: bold;\">Leader:</span> %players.leader%<br>\n"
                        + "<span style=\"font-weight: bold;\">Admins:</span> %players.admins.count%<br>\n"
                        + "<span style=\"font-weight: bold;\">Moderators:</span> %players.moderators.count%<br>\n"
                        + "<span style=\"font-weight: bold;\">Members:</span> %players.normals.count%<br>\n"
                        + "<span style=\"font-weight: bold;\">TOTAL:</span> %players.count%<br>\n"
                        + "</br>\n"
                        + "<span style=\"font-weight: bold;\">Bank:</span> %money%<br>\n"
                        + "<br>\n"
                        + "</div>";

        // Enable the %money% macro. Only do this if you know your economy manager is thread-safe.
        private boolean descriptionMoney = false;

        // Allow players in faction to see one another on Dynmap (only relevant if Dynmap has 'player-info-protected' enabled)
        private boolean visibilityByFaction = true;

        // Optional setting to limit which regions to show.
        // If empty all regions are shown.
        // Specify Faction either by name or UUID.
        // To show all regions on a given world, add 'world:<worldname>' to the list.
        private Set<String> visibleFactions = new HashSet<>();

        // Optional setting to hide specific Factions.
        // Specify Faction either by name or UUID.
        // To hide all regions on a given world, add 'world:<worldname>' to the list.
        private Set<String> hiddenFactions = new HashSet<>();

        public boolean isEnabled() {
            return enabled;
        }

        public String getLayerName() {
            return layerName;
        }

        public boolean isLayerVisible() {
            return layerVisible;
        }

        public int getLayerPriority() {
            return layerPriority;
        }

        public int getLayerMinimumZoom() {
            return layerMinimumZoom;
        }

        public String getDescription() {
            return description;
        }

        public boolean isDescriptionMoney() {
            return descriptionMoney;
        }

        public boolean isVisibilityByFaction() {
            return visibilityByFaction;
        }

        public Set<String> getVisibleFactions() {
            return visibleFactions;
        }

        public Set<String> getHiddenFactions() {
            return hiddenFactions;
        }

        // Optional per Faction style overrides. Any defined replace those in dynmapDefaultStyle.
        // Specify Faction either by name or UUID.
        private transient Map<String, DynmapStyle> factionStyles = ImmutableMap.of(
                "SafeZone", new DynmapStyle().setLineColor("#FF00FF").setFillColor("#FF00FF").setBoost(false),
                "WarZone", new DynmapStyle().setLineColor("#FF0000").setFillColor("#FF0000").setBoost(false)
        );

        public Map<String, DynmapStyle> getFactionStyles() {
            return factionStyles;
        }
    }

    public class Style {
        // Region Style
        private String lineColor = DynmapStyle.DEFAULT_LINE_COLOR;
        private double lineOpacity = DynmapStyle.DEFAULT_LINE_OPACITY;
        private int lineWeight = DynmapStyle.DEFAULT_LINE_WEIGHT;
        private String fillColor = DynmapStyle.DEFAULT_FILL_COLOR;
        private double fillOpacity = DynmapStyle.DEFAULT_FILL_OPACITY;
        private String homeMarker = DynmapStyle.DEFAULT_HOME_MARKER;
        private boolean styleBoost = DynmapStyle.DEFAULT_BOOST;

        public String getLineColor() {
            return lineColor;
        }

        public double getLineOpacity() {
            return lineOpacity;
        }

        public int getLineWeight() {
            return lineWeight;
        }

        public String getFillColor() {
            return fillColor;
        }

        public double getFillOpacity() {
            return fillOpacity;
        }

        public String getHomeMarker() {
            return homeMarker;
        }

        public boolean isStyleBoost() {
            return styleBoost;
        }
    }

    private Dynmap dynmap = new Dynmap();
    private Style style = new Style();

    public Dynmap dynmap() {
        return dynmap;
    }

    public Style style() {
        return style;
    }
}