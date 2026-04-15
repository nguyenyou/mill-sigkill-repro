package generated

final case class Data1315(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1315 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1315 = copy(value = value * k)
  def addTag(t: String): Data1315 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1315 = copy(meta = meta.updated(k, v))
  def merge(other: Data1315): Data1315 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1315 {
  given Ordering[Data1315] = Ordering.by(_.id)
  def empty: Data1315 = Data1315(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1315 =
    Data1315(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1315] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
