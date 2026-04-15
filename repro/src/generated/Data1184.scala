package generated

final case class Data1184(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1184 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1184 = copy(value = value * k)
  def addTag(t: String): Data1184 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1184 = copy(meta = meta.updated(k, v))
  def merge(other: Data1184): Data1184 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1184 {
  given Ordering[Data1184] = Ordering.by(_.id)
  def empty: Data1184 = Data1184(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1184 =
    Data1184(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1184] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
