package generated

final case class Data22(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data22 = copy(name = name.toUpperCase)
  def scale(k: Double): Data22 = copy(value = value * k)
  def addTag(t: String): Data22 = copy(tags = t :: tags)
  def put(k: String, v: String): Data22 = copy(meta = meta.updated(k, v))
  def merge(other: Data22): Data22 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data22 {
  given Ordering[Data22] = Ordering.by(_.id)
  def empty: Data22 = Data22(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data22 =
    Data22(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data22] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
