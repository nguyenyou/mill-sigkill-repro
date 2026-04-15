package generated

final case class Data1227(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1227 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1227 = copy(value = value * k)
  def addTag(t: String): Data1227 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1227 = copy(meta = meta.updated(k, v))
  def merge(other: Data1227): Data1227 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1227 {
  given Ordering[Data1227] = Ordering.by(_.id)
  def empty: Data1227 = Data1227(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1227 =
    Data1227(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1227] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
