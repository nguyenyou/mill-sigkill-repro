package generated

final case class Data611(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data611 = copy(name = name.toUpperCase)
  def scale(k: Double): Data611 = copy(value = value * k)
  def addTag(t: String): Data611 = copy(tags = t :: tags)
  def put(k: String, v: String): Data611 = copy(meta = meta.updated(k, v))
  def merge(other: Data611): Data611 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data611 {
  given Ordering[Data611] = Ordering.by(_.id)
  def empty: Data611 = Data611(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data611 =
    Data611(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data611] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
