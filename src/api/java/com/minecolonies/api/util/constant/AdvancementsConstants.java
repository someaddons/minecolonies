package com.minecolonies.api.util.constant;

/**
 * Constants for advancements.
 */
public final class AdvancementsConstants
{
    public static final String GOAL = "goal";
    public static final String CHALLENGE = "challenge";

    /**
     * Distance needed to trigger the first advancement, should be 0.5km, is a sum of WALK_ONE_CM and SPRINT_ONE_CM
     */
    public static final int WALKAROUND = 50000;

    private AdvancementsConstants()
    {
        //empty default
    }
}