package com.robertx22.stats;

import com.robertx22.effectdatas.EffectData;
import com.robertx22.saveclasses.Unit;

public interface IStatEffect {

	public abstract int GetPriority();

	public abstract EffectData TryModifyEffect(EffectData Effect, Unit Source, Stat stat);

}
