package part1.designPattern.memoryPool;

public class BulletPool extends MemoryPool<Bullet>{
    @Override
    protected  Bullet allocate(){
        return new Bullet();
    }
}
