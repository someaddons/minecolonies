package com.minecolonies.api.util;

import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.advancements.critereon.AbstractCriterionInstance;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.minecolonies.api.util.constant.Constants;

public class AdvancementsUtils
{
    /**
     * This class is part of my simple custom advancement triggering tutorial.
     * See: http://jabelarminecraft.blogspot.com/p/minecraft-modding-custom-triggers-aka.html
     * 
     * @author jabelar
     */
    public static class GenericTrigger implements ICriterionTrigger<GenericTrigger.Instance>
    {
        private final ResourceLocation RL;
        private final Map<PlayerAdvancements, GenericTrigger.Listeners> listeners = Maps.newHashMap();

        /**
         * Instantiates a new generic trigger.
         *
         * @param parString the par string
         */
        public GenericTrigger(String parString)
        {
            super();
            RL = new ResourceLocation(Constants.MOD_ID + ":" + parString);
        }
        
        /* (non-Javadoc)
        * @see net.minecraft.advancements.ICriterionTrigger#getId()
        */
        @Override
        public ResourceLocation getId()
        {
            return RL;
        }

        /* (non-Javadoc)
        * @see net.minecraft.advancements.ICriterionTrigger#addListener(net.minecraft.advancements.PlayerAdvancements, net.minecraft.advancements.ICriterionTrigger.Listener)
        */
        @Override
        public void addListener(PlayerAdvancements playerAdvancementsIn, ICriterionTrigger.Listener<GenericTrigger.Instance> listener)
        {
            GenericTrigger.Listeners myGenericTrigger$listeners = listeners.get(playerAdvancementsIn);

            if (myGenericTrigger$listeners == null)
            {
                myGenericTrigger$listeners = new GenericTrigger.Listeners(playerAdvancementsIn);
                listeners.put(playerAdvancementsIn, myGenericTrigger$listeners);
            }

            myGenericTrigger$listeners.add(listener);
        }

        /* (non-Javadoc)
        * @see net.minecraft.advancements.ICriterionTrigger#removeListener(net.minecraft.advancements.PlayerAdvancements, net.minecraft.advancements.ICriterionTrigger.Listener)
        */
        @Override
        public void removeListener(PlayerAdvancements playerAdvancementsIn, ICriterionTrigger.Listener<GenericTrigger.Instance> listener)
        {
            GenericTrigger.Listeners myGenericTrigger$listeners = listeners.get(playerAdvancementsIn);

            if (myGenericTrigger$listeners != null)
            {
                myGenericTrigger$listeners.remove(listener);

                if (myGenericTrigger$listeners.isEmpty())
                {
                    listeners.remove(playerAdvancementsIn);
                }
            }
        }

        /* (non-Javadoc)
        * @see net.minecraft.advancements.ICriterionTrigger#removeAllListeners(net.minecraft.advancements.PlayerAdvancements)
        */
        @Override
        public void removeAllListeners(PlayerAdvancements playerAdvancementsIn)
        {
            listeners.remove(playerAdvancementsIn);
        }

        /**
         * Deserialize a ICriterionInstance of this trigger from the data in the JSON.
         *
         * @param json the json
         * @param context the context
         * @return the tame bird trigger. instance
         */
        @Override
        public GenericTrigger.Instance deserializeInstance(JsonObject json, JsonDeserializationContext context)
        {
            return new GenericTrigger.Instance(getId());
        }

        /**
         * Trigger.
         *
         * @param parPlayer the player
         */
        public void trigger(EntityPlayerMP parPlayer)
        {
            GenericTrigger.Listeners myGenericTrigger$listeners = listeners.get(parPlayer.getAdvancements());

            if (myGenericTrigger$listeners != null)
            {
                myGenericTrigger$listeners.trigger(parPlayer);
            }
        }

        public static class Instance extends AbstractCriterionInstance
        {
            
            /**
             * Instantiates a new instance.
             *
             * @param parRL the par RL
             */
            public Instance(ResourceLocation parRL)
            {
                super(parRL);
            }

            /**
             * Test.
             *
             * @return true, if successful
             */
            public boolean test()
            {
                return true;
            }
        }

        public static class Listeners
        {
            private final PlayerAdvancements playerAdvancements;
            private final Set<ICriterionTrigger.Listener<GenericTrigger.Instance>> listeners = Sets.newHashSet();

            /**
             * Instantiates a new listeners.
             *
             * @param playerAdvancementsIn the player advancements in
             */
            public Listeners(PlayerAdvancements playerAdvancementsIn)
            {
                playerAdvancements = playerAdvancementsIn;
            }

            /**
             * Checks if is empty.
             *
             * @return true, if is empty
             */
            public boolean isEmpty()
            {
                return listeners.isEmpty();
            }

            /**
             * Adds the listener.
             *
             * @param listener the listener
             */
            public void add(ICriterionTrigger.Listener<GenericTrigger.Instance> listener)
            {
                listeners.add(listener);
            }

            /**
             * Removes the listener.
             *
             * @param listener the listener
             */
            public void remove(ICriterionTrigger.Listener<GenericTrigger.Instance> listener)
            {
                listeners.remove(listener);
            }

            /**
             * Trigger.
             *
             * @param player the player
             */
            public void trigger(EntityPlayerMP player)
            {
                ArrayList<ICriterionTrigger.Listener<GenericTrigger.Instance>> list = null;

                for (ICriterionTrigger.Listener<GenericTrigger.Instance> listener : listeners)
                {
                    if (listener.getCriterionInstance().test())
                    {
                        if (list == null)
                        {
                            list = Lists.newArrayList();
                        }

                        list.add(listener);
                    }
                }

                if (list != null)
                {
                    for (ICriterionTrigger.Listener<GenericTrigger.Instance> listener1 : list)
                    {
                        listener1.grantCriterion(playerAdvancements);
                    }
                }
            }
        }
    }

    public static class BuildingTrigger implements ICriterionTrigger<BuildingTrigger.Instance>
    {
        private static final ResourceLocation RL = new ResourceLocation(Constants.MOD_ID + ":building");
        private final Map<PlayerAdvancements, BuildingTrigger.Listeners> listeners = Maps.newHashMap();

        /**
         * Instantiates a new building trigger.
         */
        public BuildingTrigger()
        {
            super();
        }
        
        /* (non-Javadoc)
        * @see net.minecraft.advancements.ICriterionTrigger#getId()
        */
        @Override
        public ResourceLocation getId()
        {
            return RL;
        }

        /* (non-Javadoc)
        * @see net.minecraft.advancements.ICriterionTrigger#addListener(net.minecraft.advancements.PlayerAdvancements, net.minecraft.advancements.ICriterionTrigger.Listener)
        */
        @Override
        public void addListener(PlayerAdvancements playerAdvancementsIn, ICriterionTrigger.Listener<BuildingTrigger.Instance> listener)
        {
            BuildingTrigger.Listeners myBuildingTrigger$listeners = listeners.get(playerAdvancementsIn);

            if (myBuildingTrigger$listeners == null)
            {
                myBuildingTrigger$listeners = new BuildingTrigger.Listeners(playerAdvancementsIn);
                listeners.put(playerAdvancementsIn, myBuildingTrigger$listeners);
            }

            myBuildingTrigger$listeners.add(listener);
        }

        /* (non-Javadoc)
        * @see net.minecraft.advancements.ICriterionTrigger#removeListener(net.minecraft.advancements.PlayerAdvancements, net.minecraft.advancements.ICriterionTrigger.Listener)
        */
        @Override
        public void removeListener(PlayerAdvancements playerAdvancementsIn, ICriterionTrigger.Listener<BuildingTrigger.Instance> listener)
        {
            BuildingTrigger.Listeners myBuildingTrigger$listeners = listeners.get(playerAdvancementsIn);

            if (myBuildingTrigger$listeners != null)
            {
                myBuildingTrigger$listeners.remove(listener);

                if (myBuildingTrigger$listeners.isEmpty())
                {
                    listeners.remove(playerAdvancementsIn);
                }
            }
        }

        /* (non-Javadoc)
        * @see net.minecraft.advancements.ICriterionTrigger#removeAllListeners(net.minecraft.advancements.PlayerAdvancements)
        */
        @Override
        public void removeAllListeners(PlayerAdvancements playerAdvancementsIn)
        {
            listeners.remove(playerAdvancementsIn);
        }

        /**
         * Deserialize a ICriterionInstance of this trigger from the data in the JSON.
         *
         * @param json the json
         * @param context the context
         * @return the tame bird trigger. instance
         */
        @Override
        public BuildingTrigger.Instance deserializeInstance(JsonObject json, JsonDeserializationContext context)
        {
            String buildingName = null;

            if (json.has("building"))
            {
                buildingName = JsonUtils.getString(json, "building");

                if (buildingName == null || buildingName == "")
                {
                    throw new JsonSyntaxException("Building condition is empty or was not found");
                }
            }

            return new BuildingTrigger.Instance(buildingName);
        }

        /**
         * Trigger.
         *
         * @param parPlayer the player
         */
        public void trigger(EntityPlayerMP parPlayer, String buildingIn)
        {
            BuildingTrigger.Listeners myBuildingTrigger$listeners = listeners.get(parPlayer.getAdvancements());

            if (myBuildingTrigger$listeners != null)
            {
                myBuildingTrigger$listeners.trigger(parPlayer, buildingIn);
            }
        }

        public static class Instance extends AbstractCriterionInstance
        {
            private final String building;
            
            /**
             * Instantiates a new instance.
             *
             * @param parRL the par RL
             */
            public Instance(String buildingIn)
            {
                super(RL);
                building = buildingIn;
            }

            /**
             * Test.
             *
             * @return true, if successful
             */
            public boolean test(String buildingIn)
            {
                return building.equals(buildingIn);
            }
        }

        public static class Listeners
        {
            private final PlayerAdvancements playerAdvancements;
            private final Set<ICriterionTrigger.Listener<BuildingTrigger.Instance>> listeners = Sets.<ICriterionTrigger.Listener<BuildingTrigger.Instance>>newHashSet();

            /**
             * Instantiates a new listeners.
             *
             * @param playerAdvancementsIn the player advancements in
             */
            public Listeners(PlayerAdvancements playerAdvancementsIn)
            {
                playerAdvancements = playerAdvancementsIn;
            }

            /**
             * Checks if is empty.
             *
             * @return true, if is empty
             */
            public boolean isEmpty()
            {
                return listeners.isEmpty();
            }

            /**
             * Adds the listener.
             *
             * @param listener the listener
             */
            public void add(ICriterionTrigger.Listener<BuildingTrigger.Instance> listener)
            {
                listeners.add(listener);
            }

            /**
             * Removes the listener.
             *
             * @param listener the listener
             */
            public void remove(ICriterionTrigger.Listener<BuildingTrigger.Instance> listener)
            {
                listeners.remove(listener);
            }

            /**
             * Trigger.
             *
             * @param player the player
             */
            public void trigger(EntityPlayerMP player, String building)
            {
                List<ICriterionTrigger.Listener<BuildingTrigger.Instance>> list = null;

                for (ICriterionTrigger.Listener<BuildingTrigger.Instance> listener : listeners)
                {
                    if (listener.getCriterionInstance().test(building))
                    {
                        if (list == null)
                        {
                            list = Lists.newArrayList();
                        }

                        list.add(listener);
                    }
                }

                if (list != null)
                {
                    for (ICriterionTrigger.Listener<BuildingTrigger.Instance> listener1 : list)
                    {
                        listener1.grantCriterion(playerAdvancements);
                    }
                }
            }
        }
    }
}