// @flow
import type { TurboModule } from 'react-native/Libraries/TurboModule/RCTExport';
import { TurboModuleRegistry } from 'react-native';
import {Int32} from 'react-native/Libraries/Types/CodegenTypes';

export interface Spec extends TurboModule {
    +getImageForFont: (
        fontFamily: string,
        glyph: string,
        fontSize: Int32,
        color: Int32
    ) => Promise<any>;

    +getImageForFontSync: (
        fontFamily: string,
        glyph: string,
        fontSize: Int32,
        color: Int32
    ) => string;
}
  
  export default (TurboModuleRegistry.get<Spec>(
    'RNVectorIconsModule'
    ): ?Spec);
