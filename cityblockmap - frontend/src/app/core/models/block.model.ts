export interface Neighborhood {
    id: number;
    name: string;
}

export interface Block {
    id: number;
    number: string;
    latitude: number;
    longitude: number;
    neighborhood: Neighborhood;
}