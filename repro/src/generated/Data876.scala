package generated

final case class Data876(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data876 = copy(name = name.toUpperCase)
  def scale(k: Double): Data876 = copy(value = value * k)
  def addTag(t: String): Data876 = copy(tags = t :: tags)
  def put(k: String, v: String): Data876 = copy(meta = meta.updated(k, v))
  def merge(other: Data876): Data876 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data876 {
  given Ordering[Data876] = Ordering.by(_.id)
  def empty: Data876 = Data876(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data876 =
    Data876(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data876] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
