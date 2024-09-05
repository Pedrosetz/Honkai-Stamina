package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class infos {
    @JsonProperty("current_stamina")
    private int stamina;

    @JsonProperty("max_stamina")
    private int max_stamina;

    @JsonProperty("stamina_recover_time")
    private int staminaRecoverTime;

    @JsonProperty("stamina_full_ts")
    private long staminaFullTs;


    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMax_stamina() {
        return max_stamina;
    }

    public void setMax_stamina(int max_stamina) {
        this.max_stamina = max_stamina;
    }

    public int getStaminaRecoverTime() {
        return staminaRecoverTime;
    }

    public void setStaminaRecoverTime(int staminaRecoverTime) {
        this.staminaRecoverTime = staminaRecoverTime;
    }

    public long getStaminaFullTs() {
        return staminaFullTs;
    }

    public void setStaminaFullTs(long staminaFullTs) {
        this.staminaFullTs = staminaFullTs;
    }


}

