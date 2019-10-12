package com.minecolonies.coremod.colony;

import com.minecolonies.api.entity.ai.statemachine.states.IAIState;

public enum ColonyStates implements IAIState
{
    INACTIVE,
    ACTIVE,
    LOADING;

    @Override
    public boolean isOkayToEat()
    {
        return false;
    }
}
