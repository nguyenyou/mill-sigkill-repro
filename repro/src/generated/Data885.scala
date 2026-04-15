package generated

final case class Data885(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data885 = copy(name = name.toUpperCase)
  def scale(k: Double): Data885 = copy(value = value * k)
  def addTag(t: String): Data885 = copy(tags = t :: tags)
  def put(k: String, v: String): Data885 = copy(meta = meta.updated(k, v))
  def merge(other: Data885): Data885 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data885 {
  given Ordering[Data885] = Ordering.by(_.id)
  def empty: Data885 = Data885(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data885 =
    Data885(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data885] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
