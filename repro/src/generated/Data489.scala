package generated

final case class Data489(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data489 = copy(name = name.toUpperCase)
  def scale(k: Double): Data489 = copy(value = value * k)
  def addTag(t: String): Data489 = copy(tags = t :: tags)
  def put(k: String, v: String): Data489 = copy(meta = meta.updated(k, v))
  def merge(other: Data489): Data489 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data489 {
  given Ordering[Data489] = Ordering.by(_.id)
  def empty: Data489 = Data489(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data489 =
    Data489(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data489] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
