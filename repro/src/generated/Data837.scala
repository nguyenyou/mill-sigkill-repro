package generated

final case class Data837(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data837 = copy(name = name.toUpperCase)
  def scale(k: Double): Data837 = copy(value = value * k)
  def addTag(t: String): Data837 = copy(tags = t :: tags)
  def put(k: String, v: String): Data837 = copy(meta = meta.updated(k, v))
  def merge(other: Data837): Data837 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data837 {
  given Ordering[Data837] = Ordering.by(_.id)
  def empty: Data837 = Data837(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data837 =
    Data837(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data837] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
