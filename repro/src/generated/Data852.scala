package generated

final case class Data852(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data852 = copy(name = name.toUpperCase)
  def scale(k: Double): Data852 = copy(value = value * k)
  def addTag(t: String): Data852 = copy(tags = t :: tags)
  def put(k: String, v: String): Data852 = copy(meta = meta.updated(k, v))
  def merge(other: Data852): Data852 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data852 {
  given Ordering[Data852] = Ordering.by(_.id)
  def empty: Data852 = Data852(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data852 =
    Data852(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data852] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
