package generated

final case class Data423(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data423 = copy(name = name.toUpperCase)
  def scale(k: Double): Data423 = copy(value = value * k)
  def addTag(t: String): Data423 = copy(tags = t :: tags)
  def put(k: String, v: String): Data423 = copy(meta = meta.updated(k, v))
  def merge(other: Data423): Data423 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data423 {
  given Ordering[Data423] = Ordering.by(_.id)
  def empty: Data423 = Data423(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data423 =
    Data423(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data423] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
