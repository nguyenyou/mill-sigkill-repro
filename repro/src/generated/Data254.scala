package generated

final case class Data254(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data254 = copy(name = name.toUpperCase)
  def scale(k: Double): Data254 = copy(value = value * k)
  def addTag(t: String): Data254 = copy(tags = t :: tags)
  def put(k: String, v: String): Data254 = copy(meta = meta.updated(k, v))
  def merge(other: Data254): Data254 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data254 {
  given Ordering[Data254] = Ordering.by(_.id)
  def empty: Data254 = Data254(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data254 =
    Data254(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data254] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
