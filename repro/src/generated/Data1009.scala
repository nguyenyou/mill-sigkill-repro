package generated

final case class Data1009(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1009 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1009 = copy(value = value * k)
  def addTag(t: String): Data1009 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1009 = copy(meta = meta.updated(k, v))
  def merge(other: Data1009): Data1009 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1009 {
  given Ordering[Data1009] = Ordering.by(_.id)
  def empty: Data1009 = Data1009(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1009 =
    Data1009(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1009] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
