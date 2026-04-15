package generated

final case class Data1253(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1253 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1253 = copy(value = value * k)
  def addTag(t: String): Data1253 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1253 = copy(meta = meta.updated(k, v))
  def merge(other: Data1253): Data1253 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1253 {
  given Ordering[Data1253] = Ordering.by(_.id)
  def empty: Data1253 = Data1253(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1253 =
    Data1253(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1253] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
