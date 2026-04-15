package generated

final case class Data201(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data201 = copy(name = name.toUpperCase)
  def scale(k: Double): Data201 = copy(value = value * k)
  def addTag(t: String): Data201 = copy(tags = t :: tags)
  def put(k: String, v: String): Data201 = copy(meta = meta.updated(k, v))
  def merge(other: Data201): Data201 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data201 {
  given Ordering[Data201] = Ordering.by(_.id)
  def empty: Data201 = Data201(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data201 =
    Data201(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data201] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
