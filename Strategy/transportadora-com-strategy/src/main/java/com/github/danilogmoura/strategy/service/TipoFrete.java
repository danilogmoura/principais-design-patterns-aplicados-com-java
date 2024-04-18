package com.github.danilogmoura.strategy.service;

import com.github.danilogmoura.strategy.service.frete.Normal;
import com.github.danilogmoura.strategy.service.frete.Sedex;

public enum TipoFrete {
    NORMAL {
        @Override
        public Frete getFrete() {
            return new Normal();
        }
    }, SEDEX {
        @Override
        public Frete getFrete() {
            return new Sedex();
        }
    };

    public abstract Frete getFrete();
}
