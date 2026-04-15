package generated

final case class Data966(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data966 = copy(name = name.toUpperCase)
  def scale(k: Double): Data966 = copy(value = value * k)
  def addTag(t: String): Data966 = copy(tags = t :: tags)
  def put(k: String, v: String): Data966 = copy(meta = meta.updated(k, v))
  def merge(other: Data966): Data966 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data966 {
  given Ordering[Data966] = Ordering.by(_.id)
  def empty: Data966 = Data966(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data966 =
    Data966(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data966] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
