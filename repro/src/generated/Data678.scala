package generated

final case class Data678(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data678 = copy(name = name.toUpperCase)
  def scale(k: Double): Data678 = copy(value = value * k)
  def addTag(t: String): Data678 = copy(tags = t :: tags)
  def put(k: String, v: String): Data678 = copy(meta = meta.updated(k, v))
  def merge(other: Data678): Data678 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data678 {
  given Ordering[Data678] = Ordering.by(_.id)
  def empty: Data678 = Data678(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data678 =
    Data678(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data678] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
