package com.minecolonies.coremod.entity.ai.basic;

import com.minecolonies.api.entity.ai.DesiredActivity;
import com.minecolonies.api.entity.ai.Status;
import com.minecolonies.api.util.CompatibilityUtils;
import com.minecolonies.coremod.colony.jobs.AbstractJob;
import com.minecolonies.coremod.entity.EntityCitizen;
import com.minecolonies.coremod.entity.ai.util.ChatSpamFilter;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class AbstractEntityWorkerAI<J extends AbstractJob> extends AbstractStateMachineAI
{
    @NotNull
    protected final J             job;
    @NotNull
    protected final EntityCitizen worker;

    protected final World          world;
    @NotNull
    protected final ChatSpamFilter chatSpamFilter;

    public AbstractEntityWorkerAI(@NotNull final J job)
    {
        super();

        if (!job.getCitizen().getCitizenEntity().isPresent())
        {
            throw new IllegalArgumentException("Cannot instantiate a AI from a Job that is attached to a Citizen without entity.");
        }

        this.job = job;
        this.worker = this.job.getCitizen().getCitizenEntity().get();
        this.world = CompatibilityUtils.getWorld(this.worker);
        this.chatSpamFilter = new ChatSpamFilter(job.getCitizen());
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     *
     * @return true if execution is wanted.
     */
    @Override
    public final boolean shouldExecute()
    {
        return worker.getDesiredActivity() == DesiredActivity.WORK;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing.
     */
    @Override
    public final boolean shouldContinueExecuting()
    {
        return super.shouldContinueExecuting();
    }

    /**
     * Execute a one shot task or start executing a continuous task.
     */
    @Override
    public final void startExecuting()
    {
        worker.getCitizenStatusHandler().setStatus(Status.WORKING);
    }

    /**
     * Resets the task.
     */
    @Override
    public final void resetTask()
    {
        worker.getCitizenStatusHandler().setStatus(Status.IDLE);
    }

    /**
     * Resets the AI to Idle state, use with care interrupts all current Actions
     * TODO: Change to events
     */
    public void resetAIToIdle()
    {

    }
}
