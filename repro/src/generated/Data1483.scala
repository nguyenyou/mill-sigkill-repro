package generated

final case class Data1483(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1483 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1483 = copy(value = value * k)
  def addTag(t: String): Data1483 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1483 = copy(meta = meta.updated(k, v))
  def merge(other: Data1483): Data1483 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1483 {
  given Ordering[Data1483] = Ordering.by(_.id)
  def empty: Data1483 = Data1483(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1483 =
    Data1483(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1483] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
