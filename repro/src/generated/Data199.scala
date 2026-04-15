package generated

final case class Data199(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data199 = copy(name = name.toUpperCase)
  def scale(k: Double): Data199 = copy(value = value * k)
  def addTag(t: String): Data199 = copy(tags = t :: tags)
  def put(k: String, v: String): Data199 = copy(meta = meta.updated(k, v))
  def merge(other: Data199): Data199 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data199 {
  given Ordering[Data199] = Ordering.by(_.id)
  def empty: Data199 = Data199(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data199 =
    Data199(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data199] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
