package generated

final case class Data866(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data866 = copy(name = name.toUpperCase)
  def scale(k: Double): Data866 = copy(value = value * k)
  def addTag(t: String): Data866 = copy(tags = t :: tags)
  def put(k: String, v: String): Data866 = copy(meta = meta.updated(k, v))
  def merge(other: Data866): Data866 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data866 {
  given Ordering[Data866] = Ordering.by(_.id)
  def empty: Data866 = Data866(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data866 =
    Data866(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data866] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
